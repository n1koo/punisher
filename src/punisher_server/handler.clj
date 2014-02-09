(ns punisher-server.handler
  (use compojure.core
       punisher-server.views)
  (require [compojure.handler :as handler]
           [compojure.route :as route]
           [clojure.java.io :as io]
           [punisher-server.punisher-history :as h]
           [punisher-server.scripts :as script]))

(defn get-punish [params]
  (let [client (:client-id params)
        script (:script (rand-nth (into [] (clojure.set/select #(= (:level %) 1) script/all-scripts))))
        _ (h/add-execution client script)]
    (if (:client-id params)
      script
      (ring.util.response/not-found "Error 504: Missing client-id!!!"))))

(defroutes app-routes
           (context "/punish/api" {params :params} (defroutes punish-routes
                                                     (GET "/v1/" [] (get-punish params))))
           (GET "/" [] (index-page))
           (GET "/client" request (install-page request false))
           (GET "/client/debug" request (install-page request true))
           (route/not-found "<h1>Page not found</h1>"))

(def app
  (handler/site app-routes))
