(ns twitter-api.tweets.validation
  (:require [clojure.string :as str]
            [compojure.core :refer :all]
            [clojure.data.json :as json])
  (:gen-class))

(def minimum-body-length 1)
(def maximum-body-length 140)

(defn validate-tweet
  "validate if a tweet has all the required data"
  [tweet]
  (and
    (<= minimum-body-length (count (get tweet "body")) maximum-body-length)
    (= 0 (str/index-of (get tweet "username") "@"))
    (> (count (get tweet "username")) 2)
    ))
