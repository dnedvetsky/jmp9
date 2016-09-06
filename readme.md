Console app with database.
Used connector from previous tasks.

1. Can book tickets, remove booked tickets, add sessions (with film and date)
Date and session time - added as "text" due to sqlite parsing dates as text;

Spring core used (latest)
java-based configuration used
services are used as Service component
Different scopes used (person bean as prototype)
Autowiring classes
callbacks used for connection, session components (technically to drop database at each execution or create new one if none)
Profile is used: use -Dspring.profiles.active= (dailyPrices, nightlyPrices)

Data stored in database