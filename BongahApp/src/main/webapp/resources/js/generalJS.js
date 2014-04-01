var prevMenuIndex = 0;
var currMenuIndex = 0;
var liMenuArray = null;
var leftMarginPercentages = [0, 33, 41, 48, 65];

function setupMenuItemsMouseEventsHandler()
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
						console.log("prevMenuIndex = " + prevMenuIndex);
						var prevSubMenuId = "sub" + liMenuArray[prevMenuIndex].id;
						
						$(liMenuArray[prevMenuIndex]).attr("style", "background-color: #006633");
						$("#" + prevSubMenuId).attr("style", "display: none");
					}
					
					var subMenuId = "sub" + this.id;
					var subMenuElement = $("#" + subMenuId);
					var leftMarginPercentage = leftMarginPercentages[currMenuIndex];
					
					$(subMenuElement).attr("style", "margin-left: " + leftMarginPercentage + "%; display: visible");
					
					if (tag != 0 && tag != 4 && tag != 5) $(subMenuElement).attr("class", "subMenu horizontal pointer");
				});
		});

	$("#subMenu1").attr("style", "display: visible");
}
