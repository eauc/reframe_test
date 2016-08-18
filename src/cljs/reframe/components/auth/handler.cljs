(ns reframe.components.auth.handler
  (:require [re-frame.core :as re-frame]))

(re-frame/register-handler
 :auth-login
 (fn [db [_ token]]
   (assoc-in db [:auth :token] token)))

(re-frame/register-handler
 :auth-logout
 (fn [db [_]]
   (assoc db :auth (dissoc (:auth db) :token))))
