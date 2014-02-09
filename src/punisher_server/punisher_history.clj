(ns punisher-server.punisher-history
  (:use [korma.db]
        [korma.core])
  (:require [clj-time.core :as time]
            [clj-time.coerce :as joda]))

(defdb mydb (h2 {:db "resources/history"
                 :user "sa"
                 :password ""
                 :naming {:fields clojure.string/upper-case}}))

(defentity history)

(defn add-execution [client script]
  (insert history
          (values {:clientid client :script script})))

(defn client-history [client]
  ((keyword client) @history))

(defn all-history []
  (select history (order :ID :DESC)))
