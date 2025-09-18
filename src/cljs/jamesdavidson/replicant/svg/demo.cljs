(ns jamesdavidson.replicant.svg.demo
  (:import [goog.string format])
  (:require [replicant.dom :as r]))

(declare refresh)

(defonce state
  (doto (atom {:n 0})
    (add-watch :render (fn [k r o n] (refresh n)))))

(r/set-dispatch!
  (fn [replicant-data handler-data]
    (swap! state update :n inc)))

(defn refresh [s]
  (r/render (js/document.getElementById "app")
    [:div.container
     [:main
      [:h2 "Replicant SVG Demo"]
      [:p (format "Just wrote some documentation for Replicant. %d" (get s :n 0))]
      [:input {:type "button"
               :value "inc"
               :on {:click [:foo]}}]
    [:svg {:height 150 :width 500 :xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 200 200"}
      [:ellipse {:cx "240"
                 :cy "100"
                 :rx "220"
                 :ry (-> s :n (* 10))
                 :fill "purple"}]
      [:ellipse {:cx "220"
                 :cy "70"
                 :rx "190"
                 :ry "20"
                 :fill "lime"}]
      [:ellipse {:cx "210"
                 :cy "45"
                 :rx "170"
                 :ry "15"
                 :fill "yellow"}]]
      [:p.opacity-50
       "Posted 18th September 2025"]]]))

(defn -main [& args]
  (refresh @state))
