Functional Tests Cases/Scenarios


    1.Simple Customer Login and Transactions Flow
       steps: select name-> deposit- > withraw- > account details and balnace are correct - >transaction table result

    2 .check simple login flow with few diferent names (harry potter...)
    3. check home button works in all pages
    4. check logout button works in all pages ( after login)
    5. login do simple transaction   then logout then login again and do simple transaction

    5. try to withdraw when there is no deposit
    6. try to withdraw amount that is higher than the amount that was deposited
    7  try to enter non integer  string to deposit/withdraw text boxes (1gd/ds/d3)
    8  enter a very large numbers to deposit/withdraw text boxes
    9. enter a float number (10.50) to  deposit/withdraw text boxes
    10  enter a number to deposit/withdraw text boxes then erase it and check if seposit button enabled
    11. enter zeros  to deposit/withdraw text boxes
    12  enter spaces and  then number to deposit/withdraw text boxes (  23)
    13. add incorrect number to deposit/withdraw text boxes (092)
    15  enter a large amount of deposits and withdraws
    16 check transaction amount is not changed before clicking the deposit/withdraw button

    14. check that one user transactions doesnt influence on a different user account
    16. try simple customer login and Transactions Flow with different browsers on pc
    17. try simple customer login and Transactions Flow with different browsers on smartphone (android/apple)
    18  try to enter to an after login pages wit url
    19  erase cookies,  try to enter to after login pages wit url
    20  logout and try to return to an after login pages with browser back to page button
    21  login with first tab switch to a second tab with same url
    22  login -> open another instance of a browse and enter the bank project page
    23  login, close browser, reopen it and return to site.
    23  check process with different pc resolutions
    24  check site when window is resized



    Non Functions
     1. check simple flow timing is  acceptable
     1. simulate moderate/high  different transaction  with same / diffrenet users
     2  check if site responsive when there are many users with many transactions
     3. simulate normal/moderate/high session at the same time
     4. check if site is responsive
     4. check dom that sensitive  data is not available
     5. check that user credentials are not saved in any way ( browser,cookies,local file..)  and are not stored in DB
     6. Validate Html/Dom syntex
     7. cretate netwok connection issues
     8. check for memory leaks and server cpu mem usage
     9 . check that login and after login are https
     10. try to create an error or an exception and check that sensitive data is not displayed






