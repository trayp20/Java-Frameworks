

# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS

## Part C: Updating User Profile

### Prompt:
- Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

### Changes:
- **File:** mainscreen.html
- **Line Number:** 14,19,21,35
- **Change:** 
	-**Change line 14 named to Tray Computer Shop 
	-**Change line 19 to Tray Computer Shop
	-**Change line 21 to Computer Parts
	-**Change line 35 to Computer Part

##Part D:Creating AboutMe Page

### Prompt:
-Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

###Changes:
- **File** added aboutme.html
- **Line Number:** 5,8,9,10,11,12,13,14,15,16,17,18,19,20,
- **Change:**
	-** Change line 5 added Title 
	-** Change line 8 added header 1
	-** change line 9 p added paragraph 
	-** change line  10 added header 2
	-** change line 11 added paragraph 
	-** change line 12 added header 2
	-** change line 13 added paragraph
	-** change line 14 added header 2
	-** change line 15 added paragraph
	-** change line 16 added  header 2
	-** change line 17 added paragraph
	-** change line 18 added break
	-** change line 19 added break
	-** change line 20 added link to main screen page
- **File** mainscreen.html
- **Line Number** 90
- **Change:**
	-** change line 90 added link to aboutme page
- **File** added AboutMeController.java
- **Line Number:** 1,3,4,6,7,8,9,10
- **Change**
	-** change line 1 added a package
	-** change line 3 added a import
	-** change line 4 added a import
	-** change line 6 added a controller
	-** change line 7 added a class
	-** change line 8 added Getmapping
	-** change line 9-10 added a return method

##Part E:Sample Inventory

### Prompt:
-Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

###Changes:
- **File** BootStrapData.java
- **Line Number** 42 through 114
- **Change**
	-** change line 42 add check to database to see if empty
	-** change line 45-78 added computer part
	-** change line 80-109 added computer product 
	-** change line  111 added print statement
	-** change line 112 added else statement
	_*8 change linne 113-114 add print statement 
##Part F:Buy Now Button

### Prompt:
-Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

###Changes:
- **File** mainscreen.html
- **Line** 86 through 89
- **Change**
	-** change 86 through 89 add a form for a button 

- **File** AddProductController.Java
- **Line** 16,179 through 192
_ **Change** 
	-** change line 16 added a import
	-** change line 179-192 added created Post Request to handle the buying process

- **File** purchaseSucess.html
- **Line** 5,8
-** Change**
	-** change Line 5 added a title
	-** change 8 added a Header 1

- **File** purchaseError.html
- **Line** 5,8
-** Change**
	-** change Line 5 added a title
	-** change 8 added a Header 1

###Part G:Track max and min inventory
###Prompt 
-Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

###Changes:
-**File** Part.java
-**Line** 33,32,42,46,47,97,98,99,100
-**Change**	
	-** change line 33 Added variable for minInv 
	-** change line 32 added variable for  maxInv
	-** change line 42 ,46,47 added minInv and maxInv to the constructor
	-** change line 97 added a getter method for minInv
	-** change line 98 added a setter method for minInv
	-** change line 99 added a getter method for maxInv
	-** change line 100 added a setter method for maxInv

-**File** BootStrapData.java
-**Line** 50,51,59,60,68,69,77,78,86,87
-**Change**
	-** change 50 set minimum inventory
	-** change 51 set maximum inventory
	-** change 59 set minimum inventory
	-** change 60 set maximum inventory
	-** change 68 set minimum inventory
	-** change 69 set maximum inventory
	-** change 77 set minimum inventory
	-** change 78 set maximum inventory
	-** change 86 set minimum inventory
	-** change 87 set maximum inventory

-**File** InhousePartForm.html
-**line 26,27,28
-**Change**
	-** change 26 added comment
	-** change 27 added text input for minimum inventory
	-** change 28 added text input for maximum inventory

-**File** OutsourcedPartForm.html
-**line 27,28,29
-**Change**
	-** change 27 added comment
	-** change 28 added text input for minimum inventory
	-** change 29 added text input for maximum inventory

-**File** application.properties
-**Line** 6
-**Change**
	-** change spring-boot-h2-db to parts-management-db

-**File** Part.Java
-**Line** 106,107,108
_**Change*8
	-** line 106 added comment for validation method
	-** line 107-108 added an isInvValid method
-**File** AddInHousePartConbtroller.java
_**Line 33,34,53,54,55,56,57,58,59,60,61,62,63 64
_**Change**
	-** change line 33 through 34 injecting the part repository
	-** Change line 53 added PostMapping
	-** Change line 54 through 57 added Is inventory valid method
	-** Change line 58-60 added error handling
	-** change line 61 -64 added a form redirection

-**File** AddOutsourcedPartConbtroller.java
_**Line 6,20,34,35,36,37,60,61,62,63,64,65,66,67,68,69,70,71
-**Change**
	-** change line 6 added import
	-** change line 20. Added import
	-** change line 34-35 injecting the part repository
	-** changes line 36-37 added autowired
	-** Change line 60 added PostMapping
	-** Change line 61 through 64 added IsInventoryvalid method
	-** Change line 65 through 67 added error handling
	-** change line 68 -71 added a form redirection

###Part H 
###Prompt
-H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.


-**File** AddInHousePartController.java
-**Line** 59,63,64,65,66,67,68,69,70
-**Change**
	-**Change line 59 add a variable to store inventory 
	-**Change line 63 through 66 added logic to check if inventory is below minimum
	-**Change line 67 through 70 added logic to check if inventory is above maximum


-**File** EnuffPartsValidator.java
-**Line** 35,39,40,41,42,43,44,45
-**Change**
	-**Change line 35 calculate the inventory change for the product
	-** Change 39 through 45 check if inventory for any part will fall below min required

###Part I
###Prompt
-Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

-**File** PartTest.java
-**Line** 159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175
-**Change**
	-** change line 159 through 167 added a test for minimum Inventory
	-** change line 168 through 175 added a test for maximum Inventory
	
##Part J
###Prompt
-Remove the class files for any unused validators in order to clean your code.

-**File** DeletePartValidator.java
-**Line** all the lines
-**Change**
	-**Change delete DeletePartValidator.java file 


##Part Revision
##Prompt 
-revision to my code

-**File** mainscreen.html
-**Line** 21,22,23,100
-**Change** 
	-**change line 21 through 23 added alert for the buy now button
	-**change line 100 fix aboutme link

-**File AddProductController.java
-**Line** 181 throught 199
-**Change**	
	-** change line 181 through 199 updated PostMapping for the buyProduct

-**File** application.properties
-**Line** 6
-**Change**
	-** change line 6 add my student number to parts management

-**File** purchaseSuccess.html
-**Line** all
-** Change**
	-**change deleted file

-**File** purchaseError.html
-**Line** all
-** Change**
	-**change deleted file

-**File** BootStrapData.java
-**Line* 8 126,127,128,129
-**Change*
	-**change line 126 through 129 commented out code

-**File** aboutme.html
-**Line** 20
-**Change**
	-**change line 8 updated link to mainscreen

-**File** AddInHousePartController,java
-**Line** 57 through 64
-**Change*8
	-** change line 57 through 64 updated saveInHousePart

-**File AddOutsourcedPartController,java
-**Line** 60 through 68
-**Change*
	-** change line 60 through 68 updated saveOutsourcedPart

-**File** EnufPartsValidator.java
-**Line** 50 through 65
-**Change*
	-**change line 50 through add more constraint validator

-**File** InventoryValidator.java
-**Line** 1 through 30
-**change**
	-**change line 1 through 6 added imports
	-**change line 8 added a InventoryValidator class
	-change line 10 through 13 add a initialize method
	-**change line 15 through 31 added isValid method

-**File** ValidInventory.java
-**Line** 1 through 15
-**change**
	-**change 1 through 5 added import
	-**change 7 through 15 add annotations 

-**File** Part.Java
-**line 20 36,37, 39,40
-**Change**
	-**change line 20 added annotation
	-**change line 36 through 37 added validation method
	-**change line 39 through 40 added validation method