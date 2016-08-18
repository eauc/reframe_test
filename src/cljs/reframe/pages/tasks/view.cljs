(ns reframe.pages.tasks.view
  (:require [reframe.components.auth.view :as auth]))

(def menu
  [[:div "Tasks Menu 1"]
   [:div "Tasks Menu 2"]
   [:div "Tasks Menu 3"]])

(defn page []
  [:div
   [auth/require-login
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    [:div "Line"]
    ]
   ])
