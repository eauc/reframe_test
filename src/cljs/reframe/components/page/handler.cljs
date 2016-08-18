(ns reframe.components.page.handler
    (:require [re-frame.core :as re-frame]))

(re-frame/register-handler
 :pages-set-active
 (fn [db [_ active-page]]
   (assoc-in db [:pages :active] active-page)))
