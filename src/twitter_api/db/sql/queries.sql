-- A :result value of :n below will return affected rows:
-- :name sql-insert-tweet :! :m
-- :doc Persist a tweet on datbase
insert into tweets (id, body, username)
values ((:id)::uuid , :body, :username)

-- A :result value of :n below will return affected rows:
-- :name sql-search-tweets-by-username :?
-- :doc Find tweets from a specific username
select (id, body, username) from tweets
where username = :username