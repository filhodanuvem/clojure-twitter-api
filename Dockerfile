FROM clojure:openjdk-17-lein 
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN ls 
RUN lein uberjar
CMD java -jar target/uberjar/clojure-twitter-api