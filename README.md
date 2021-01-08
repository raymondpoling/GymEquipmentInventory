
# Table of Contents

1.  [Problem statment](#orgf9f08bd)
2.  [Main Activity](#org0af04e3)
3.  [Information](#org38ff695)
    1.  [Detailed Information](#org2bd59f2)
    2.  [List item](#orgbc6714b)
4.  [Data Model](#org53b096b)
    1.  [Equipment](#org00a0c4b)
    2.  [Record](#org3ba3896)
5.  [Flow](#org179426c)
6.  [](#org9660b57)


<a id="orgf9f08bd"></a>

# Problem statment

Homework Week 2 Day 3 Create an application for a gym manager that allows him
to store and view gym equipment purchased for the gym.

-   Application should use styles(Making look good)
-   application should use SQLite to store gym items locally
-   Application should use a ListView with a Base Adapter
-   User should be able to insert and view gym items inserted + a collective
    total of cash spent
-   When the user clicks on a gym item it should open a details page
-   use Parcelable


<a id="org0af04e3"></a>

# Main Activity

-   Show list of current objects (gym equipment)
-   Provide a default image if one isn't provided
-   Bottom view:
    -   Provide value total
    -   Button for adding new equipment


<a id="org38ff695"></a>

# Information


<a id="org2bd59f2"></a>

## Detailed Information

-   image url (for display)
-   equipment name
-   quantity
-   price
-   location
-   long description
-   Short description (??? derived from long ???)


<a id="orgbc6714b"></a>

## List item

-   image url
-   equipment name
-   quantity
-   per unit/total cost


<a id="org53b096b"></a>

# Data Model


<a id="org00a0c4b"></a>

## Equipment

-   AUTO INT primary key
-   VARCHAR name
-   TEXT url (unpredictable name)
-   TEXT description
-   NUMBER price
-   VARCHAR location


<a id="org3ba3896"></a>

## Record

-   INT quantity
-   VARCHAR location
-   foreign key equipment


<a id="org179426c"></a>

# Flow

-   List of equipment short view
-   On clicking line item, show locations and locations. What about a detailed
    view?
-   Click bottom button to add items
    -   Detailed view asking all the usual questions. Allow for using existing
        equipement or new items. Should it be a wizard with list views?
    -   What about price changes in equipment?


<a id="org9660b57"></a>

# 

