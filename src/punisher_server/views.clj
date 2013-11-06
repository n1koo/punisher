(ns punisher-server.views
  (:use [hiccup core page]
        punisher-server.punisher-history))

(defn history-entry [he]
  (str (:script he) " " (:timestamp he)))

(defn entry-history [hist]
  (let [_ (println hist)
        as (map history-entry hist)]
     as))

(defn history-html [history-entrys]
  (let [client (first history-entrys)
        entrys (second history-entrys)
        ehh (entry-history entrys)]
    (str client " " ( into [] ehh))))

(defn index-page []
  (html5
    [:head
     [:title "Solita Punisher"]
     (include-css "/css/style.css")]
    [:body]
    [:h1 "Punisher"]
    [:h4 (map history-html (all-history))]))
