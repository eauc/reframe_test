(ns reframe.components.auth.sub
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
 :auth-login-active
 (fn [db _]
   (reaction (not (nil? (get-in @db [:auth :token]))))))
