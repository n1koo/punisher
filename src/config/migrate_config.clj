(ns config.migrate-config
  (:use [drift.builder :only [incremental-migration-number-generator]]
        [korma core db]))

(defdb db (h2 {:db "resources/history"
                 :user "sa"
                 :password ""
                 :naming {:fields clojure.string/upper-case}}))

(defn- maybe-create-schema-table
  "Creates the schema table if it doesn't already exist."
  [args]
  (exec-raw "CREATE TABLE IF NOT EXISTS schema_version (version INTEGER NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP())"))

(defn current-db-version []
  (or (:version (first (select :schema_version (fields :version) (order :created_at :DESC) (limit 1)))) 0))

(defn update-db-version [version]
  (insert :schema_version (values {:version version})))

(defn migrate-config []
  {:directory "src/migrations/"
   :ns-content "\n  (:use [korma core db])"
   :namespace-prefix "migrations"
   :migration-number-generator incremental-migration-number-generator
   :init maybe-create-schema-table
   :current-version current-db-version
   :update-version update-db-version })
