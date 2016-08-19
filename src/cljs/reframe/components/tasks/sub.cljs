(ns reframe.components.tasks.sub
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
 :tasks
 (fn [db _]
   (reaction (or (get-in @db [:tasks :data]) []))))

(re-frame/register-sub
 :tasks-create
 (fn [db [_ field]]
   (reaction (get-in @db [:tasks :create field]))))
