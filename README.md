# Rideshare

**Program Description:**

This program fins how many people will make it to their destination. There are 32 stations and 50 passengers, with the number of cars varying. A car is assigned a starting station and a designated location. On the way, the car cna pick up passengers who are going the same direction as the car. If the passengers reaches their destination before the car, they are dropped off. Otherwise, the passenger will get dropped off when the car reaches its destination. The passenger will then have to wait for another car to come by and pick them up. I created a passenger.java file that keeps track of each passenger's start and stop location. The car.java file then uses that information to understand who it can pick up. The car.java file also relies on the station.java file to understand directions since the station gives back right and left bounds. For the road.java file, its main function is the moveCars method. This method controls the loading and unloading of the passengers to and from the cars while making use of the car's move and unload methods. Additionally, it helps create the random starts and stops for both the cars and the passengers. Lastly, the tester file initializes all the components and moves the cars to get a result. In the tester file, I calculated the percentages for the simulation, and by changing the number of cars, it displays the percent changes.

**Results of Simulation with 20 Cars:**

I ran the simulation with 20 cars 10 times and average the results for this calculation.

Simulation 1: 56%
Simulation 2: 50%
Simulation 3: 57%
Simulation 4: 46%
Simulation 5: 50%
Simulation 6: 46%
Simulation 7: 60%
Simulation 8: 64%
Simulation 9: 62%
Simulation 10: 54%

Average Percent with 20 Cars = 54.5%

**Results of Simulation with 40 Cars:**

I ran the simulation with 40 cars 10 times and average the results for this calculation.

Simulation 1: 50%
Simulation 2: 50%
Simulation 3: 56%
Simulation 4: 50%
Simulation 5: 76%
Simulation 6: 34%
Simulation 7: 54%
Simulation 8: 56%
Simulation 9: 62%
Simulation 10: 46%

Average Percent with 40 Cars = 53.4%

**Successes and Challenges:**

One part of this project I am proud of is how I was able to realize when parts of my previous code were missing variables or getters necessary for a file that built upon it. I also think I stayed pretty organized throughout the files, and I added comments explaining my thought process behind the code. They were also good reminders for myself when it got more complex and I had to reference methods from different files.

A challenge I had was with the moveCars method in road.java. I spent a long time figuring out the loops in there because there were a lot of variables and aspects it got me confused at times. I also didn't figure out until later but I had wrote Passenger(start,end) in addPeople and addCars when it should've have been Passenger(end,start).

