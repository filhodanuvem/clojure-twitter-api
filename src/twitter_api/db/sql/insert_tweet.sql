-- A :result value of :n below will return affected rows:
-- :name insert-tweet :! :m
-- :doc Persist a tweet on datbase
insert into tweets (uuid, body, username)
values ((:uuid)::uuid , :body, :username)
