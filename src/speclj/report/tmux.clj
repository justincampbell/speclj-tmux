(ns speclj.report.tmux
  (:use
    [speclj.results :only (categorize)]
    [clojure.java.shell :only [sh]])
  (:import
    [speclj.reporting Reporter]))

(defn tmux-set [location color]
  (sh "tmux" "set" location color))

(defn tmux-set-color [color]
  (tmux-set "status-left-bg" color))

(defn pick-color [results]
  (let [result-map (categorize results)
        tally (apply hash-map (interleave (keys result-map) (map count (vals result-map))))
        color (if (zero? (:fail tally)) "green" "red")]
    (tmux-set-color color)))

(deftype TmuxReporter []
  Reporter
  (report-message [this message])
  (report-description [this description])
  (report-pass [this result])
  (report-pending [this result])
  (report-fail [this result])
  (report-runs [this results]
    (pick-color results)))

(defn new-tmux-reporter []
  (TmuxReporter.))
