var prevMenuIndex = 0;
var currMenuIndex = 0;
var liMenuArray = null;
var leftMarginPercentages = [0, 33, 41, 48, 65];

function setupMenuItemsMouseEventsHandlers()
{
	liMenuArray = $("#menuUl li");

	liMenuArray.each(function(index, element)
		{
			var tag = $(element).attr("tag");
			
			if (tag == 0 || tag == 4 || tag == 5)
			{
				// Add mouseout event
				$(element).mouseleave(function(eventObject)
					{
						$(this).attr("style", "background-color: #006633");
					});
			}

			// Add mouse enter for everyone of the menu items
			$(element).mouseenter(function(eventObject)
				{	
					// Display the hover color
					$(this).attr("style", "background-color: #009933");
					
					prevMenuIndex = currMenuIndex;
					currMenuIndex = tag;
					
					// Make the previous submenu invisible
					if(prevMenuIndex != currMenuIndex)
					{
						// Put back the non-hover color
						$(liMenuArray[prevMenuIndex]).attr("style", "background-color: #006633");

						var prevSubMenuElement = $("#" + "sub" + liMenuArray[prevMenuIndex].id);
						
						if (prevSubMenuElement) $(prevSubMenuElement).attr("style", "display: none");
					}

					var subMenuId = "sub" + this.id;
					var subMenuElement = $("#" + subMenuId);
					var leftMarginPercentage = leftMarginPercentages[currMenuIndex];
					
					if (subMenuElement)
					{
						$(subMenuElement).attr("style", "margin-left: " + leftMarginPercentage + "%; display: visible");

						if (tag != 0 && tag != 4 && tag != 5) $(subMenuElement).attr("class", "subMenu horizontal pointer");
					}
				});
		});

	// Add click handler for Login menu item
	$("#Menu5").click(handleLogin);

	$("#subMenu1").attr("style", "display: visible");
}

function handleLogin()
{
	$( "#loginDiv" ).dialog({
		autoOpen: true,
	    height: 230,
	    width: 500,
	    modal: true,
	    buttons:
	    {
	    	Login: function()
	    		{
	    			$("#loginForm").submit();
	    		}
	    }
	});
}

function formAJAXSubmit(/*form element*/ form)
{
	
}
