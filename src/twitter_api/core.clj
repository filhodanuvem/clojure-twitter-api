(ns twitter-api.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [ring.middleware.json :as ring-mid-json]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [clojure.tools.logging :as log]
            [twitter-api.tweets.database :as d])
  (:gen-class))


(defn add-tweets
  "index route"
  [req]
  (let [saved (try
                (d/post-tweet (:body req))
                (catch Exception e
                  (do
                    (log/error (.getMessage e))
                    false)))]
    {:status  (if (true? saved) 200 400)
     :headers {"Content-Type" "text/html"}
     :body    (if
                (false? saved)
                "error or saving tweet")}))
(defroutes app
             (ring-mid-json/wrap-json-body (POST "/tweets" [] add-tweets) {:keywords? true :bigdecimals? true}))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [port 3000]
    (server/run-server #'app {:port port})
    (println (str "Running service on port " port ))))
