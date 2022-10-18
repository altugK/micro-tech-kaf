CREATE KEYSPACE kafeinkeyspace
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};