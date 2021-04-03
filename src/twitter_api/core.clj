(ns twitter-api.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [clojure.tools.logging :as log]
            [twitter-api.handlers :refer :all]
            [twitter-api.tweets.database :as d])
  (:gen-class))

(defroutes app-routes        
  (POST "/tweets" [] post-twitter-handler)

  (GET "/tweets/:username" {{:keys [username]} :params}
    (let
      [tweets (d/search-tweets-by-username username)]
      {:status 200
      :headers {"Content-type" "application/json"}
      :body tweets})))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [port 3000]
    (server/run-server  (wrap-defaults #'app-routes api-defaults)  {:port port})
    (println (str "Running service on port " port ))))