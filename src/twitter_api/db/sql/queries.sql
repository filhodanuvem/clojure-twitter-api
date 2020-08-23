-- A :result value of :n below will return affected rows:
-- :name sql-insert-tweet :! :m
-- :doc Persist a tweet on datbase
insert into tweets (uuid, body, username)
values ((:uuid)::uuid , :body, :username)

-- A :result value of :n below will return affected rows:
-- :name sql-search-tweets-by-username :?
-- :doc Find tweets from a specific username
select (uuid, body, username) from tweets
where username = :username