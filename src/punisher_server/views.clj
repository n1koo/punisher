(ns punisher-server.views
  (:use [hiccup core page]
        punisher-server.punisher-history))

(defn history-entry [he]
  (str (:script he) " " (:timestamp he)))

(defn entry-history [hist]
  (let [_ (println hist)
        as (map history-entry hist)]
     as))
(defn history-list [client]
  "Single list collecting"
  (let [created_at (:CREATED_AT client)
        script (:SCRIPT client)
        clientid (:CLIENTID client)
        ]
      [:tr [:td created_at][:td clientid][:td script]]))

(defn index-page []
  (html5
    [:head
     [:title "Solita Punisher"]]
    [:body]
    [:h1 "Punisher"]
    [:table {:border "1"}
     [:tr [:th "Created"][:th "Client ID"][:th "Script"]]
      (map #(history-list %) (all-history))]))


(defn install-page [request]
  {
    :status 200
    :headers {"Content-Type" "text/plain"}
    :body (str "curl -s http://" (:server-name request) ":" (:server-port request) "/punish/api/v1/?client-id=`hostname |shasum |cut -d' ' -f1`")
    })
