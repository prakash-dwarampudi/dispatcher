1. Create a Replication Agent on Author
2. Create a Dispatcher Flush Agent on Author.

Now When a page is activated.
1. Browser send replicate.json POST request to Author Server.
2. From author Two Sling Jobs would be created with following topics
3. one for com/day/cq/replication/job/publish
4. another for com/day/cq/replication/job/flush

Publish job would send the page from Author to publish
Flush job would send a cache invalidate request to the dispatcher.

Disadvantage of Author Flush agents
-----------------------------------
Since sling jobs are asynchronous, there is a chance that Flush job would run first clearing dispatcher cache.
Then a request for the page received on the webserver serves the old page from publish instance
then publish job executes and updates the content to publish server.

