(ns twitter-api.tweets.validation
  (:require [clojure.string :as str]
            [compojure.core :refer :all]
            [clojure.data.json :as json])
  (:gen-class))

(defn- minimum-body-length 1)
(defn- maximum-body-length 140)

(defn validate-tweet
  "validate if a tweet has all the required data"
  [tweet]
  (and
   (not (empty? tweet))
   (<= minimum-body-length (count (:body tweet)) maximum-body-length)
   (= 0 (str/index-of (:username tweet) "@"))
   (> (count (:username tweet)) 2)))
