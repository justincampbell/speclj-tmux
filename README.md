# speclj-tmux

## Usage

```
lein spec -a -f growl
```

## Installation

Just make sure `speclj-tmux` is somewhere in your dependencies. I put it here:

```clj
:profiles {:dev {:dependencies [[speclj-tmux "1.0.0"]]}}
```

Here's an entire `project.clj`:

```clj
(defproject myproject "1.2.3"
  :description "My Project"
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :plugins [[speclj "2.5.0"]]
  :test-paths ["spec/"]
  :profiles {:dev {:dependencies [[speclj "2.5.0"]
                                  [speclj-tmux "1.0.0"]}})
```

## Thanks

[Paul Gross](https://github.com/pgr0ss), for his work on [speclj-growl](https://github.com/pgr0ss/speclj-growl).
