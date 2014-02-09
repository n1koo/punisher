(ns migrations.001-base-schema
  (:use [korma core db]))

(defn up []
  (transaction
   (exec-raw (str "CREATE TABLE history ("
                  "id INT PRIMARY KEY AUTO_INCREMENT,"
                  "clientid VARCHAR(255),"
                  "script VARCHAR(255),"
                  "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP()"
                  ")"))))

(defn down []
  (transaction
   (exec-raw "DROP TABLE history")))
