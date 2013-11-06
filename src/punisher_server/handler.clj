(ns punisher-server.handler
  (:use compojure.core
        punisher-server.views)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [punisher-server.punisher-history :as h]))

(defn get-scripts-for-level
  ([] (get-scripts-for-level 1))
  ([level]
   (io/file (str "resources/private/punish-scripts/" level "/"))))

(defn get-punish [params]
  (let [scripts (io/file (get-scripts-for-level 2))
        script (first (shuffle (rest (file-seq scripts))))
        client (:client-id params)
        _ (h/add-execution client script)]
    (if (:client-id params)
      script
      (ring.util.response/not-found "Error 504: Missing client-id!!!"))))

(defroutes app-routes
  (context "/punish/api" {params :params} (defroutes punish-routes
                                        (GET "/v1/" [] (get-punish params))))
  (GET "/" [] (index-page))
  (route/not-found "<h1>Page not found</h1>"))

(def app
  (handler/site app-routes))
