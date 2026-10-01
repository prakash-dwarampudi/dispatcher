/cache
{
  /statfilelevel "5"
}

the 
/rules section under /cache defines what requests can be cached.
if a page matching the rules is accessed, it is cached.

when a Activation/De-activation request comes to dispatcher, it will do two things

1. it will delete the html file mentioned in the CQ-Path header.
2. it will create stat files in all the directories in the path up to the level mentioned in statfilelevel
   from cache root
  
for example if the path is 
/content/usa-cities/en/locations/orange-county/airport-are.html

it will create stat files upto the following folder
/var/www/htdocs/content/usa-cities/en/locations/orange-county/.stat


susequently when a page is accessed, the cached file time stamp is checked against the stat file timestamp from the heirarcy.

if stat file is new, it will send the request to publisher and file would be cached again
if cached file is newer than stat file, cached file would be served.



