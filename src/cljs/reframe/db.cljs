(ns reframe.db
    (:require [re-frame.core :as re-frame]))

(def default-db
  {:name "ReFrame"
   :pages {:home  {:label "Home"  :url "/" }
           :tasks {:label "Tasks" :url "/tasks" }}})

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   default-db))
