(ns punisher-server.punisher-history
  (require [clj-time.core :as time]))

(def history (atom {}))

(defn add-execution [client script]
  (let [entry {:script script :timestamp (time/now)}]
    (swap! history #(assoc %
                           (keyword client)
                           (conj ((keyword client) %) entry)))))

(defn client-history [client]
  ((keyword client) @history))

(defn all-history []
  @history)
