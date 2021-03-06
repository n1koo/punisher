(defproject punisher-server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.4"]
                 [korma "0.3.0-RC5"]]
  :plugins [
            [lein-ring "0.8.5"]
            [drift "1.5.2"]
           ]
  :aot :all
  :ring {:handler punisher-server.handler/app}
  :profiles
  {:dev {:dependencies [
                        [drift "1.5.2"]
                        [ring-mock "0.1.5"]
                        [korma "0.3.0-RC5"]
                        [com.h2database/h2 "1.3.170"]
                        [clj-time "0.6.0"]
                       ]}})
