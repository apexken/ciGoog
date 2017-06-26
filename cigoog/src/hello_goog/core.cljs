
(ns hello-goog.core
  (:require [goog.object :as gob]
            [goog.dom :as dom]
            [goog.dom.classes :as classes]
            [goog.dom.classlist :as klist]
            [goog.events :as events]
            [cigoog.types :as cgty])
  (:import [goog Timer]))

(enable-console-print!)

(defn pln [& stuff]
  (println stuff))

(declare mk-menu)

(let [root (dom/getElement "cigoogroot")]

  (dom/removeChildren root)


  ;; (mk-menu root)
  ;; (mk-click-me root)

  ;(set! (.-className boo) "mdl-cell mdl-cell--1-col")
  ;(set! (.-className boo) ripple-button)
  ;(set! (.-className bing) "mdl-cell mdl-cell--2-col")
  ;(set! (.-className top) "mdl-grid")
  ;(dom/appendChild body top)

  #_
      (doto (Timer. 1000)
        (events/listen "tick" #(.warn js/console "still here!"))
        (.start)))

(def ripple-button "mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent")

(defn mk-click-me [par]
  (let [b (dom/createElement "button")
        txt (dom/createTextNode "Click me, too!!!")]
    (dom/appendChild b txt)
    (events/listen b "click" (fn [evt]
                               (pln :evt evt)
                               (pln :tgt (.-type evt))
                               (pln :alt (.-altKey evt))))

    (set! (.-className b) ripple-button)
    (dom/appendChild par b)
    (dom/appendChild par b)))

;<!-- Left aligned menu below button -->
;<button id="demo-menu-lower-left"
;class="mdl-button mdl-js-button mdl-button--icon">
;<i class="material-icons">more_vert</i>
;</button>
;
;<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
;for="demo-menu-lower-left">
;<li class="mdl-menu__item">Some Action</li>
;<li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another Action</li>
;<li disabled class="mdl-menu__item">Disabled Action</li>
;<li class="mdl-menu__item">Yet Another Action</li>
;</ul>

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  (println "figwheel reloading!!!!!!"))

(defn mk-menu [par]
  (let [btn (dom/createElement "button")
        ico (dom/createElement "i")
        ul (dom/createElement "ul")]

    (set! (.-className ico) "material-icons")
    (set! (.-innerHTML ico) "more_vert")
    (dom/appendChild btn ico)

    (set! (.-id btn) "menu42btn")
    (set! (.-className btn) "mdl-button mdl-js-button mdl-button--icon")

    (set! (.-id ul) "ul42")
    (set! (.-className ul) "mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect")
    (.setAttribute ul "for" "menu42btn")

    (doseq [mt ["Some CLJS Action" "Another Action" "Disabled Action" "YAAction"]]
      (let [mi (dom/createElement "li")]
        (set! (.-innerHTML mi) mt)
        (set! (.-className mi) "mdl-menu__item")
        (case mt
          "Disabled Action" (.setAttribute mi "disabled" "true")
          "Another Action" (klist/add mi "mdl-menu__item--full-bleed-divider")
          nil)
        (dom/appendChild ul mi)))

    (dom/appendChild par btn)
    (dom/appendChild par ul)))
