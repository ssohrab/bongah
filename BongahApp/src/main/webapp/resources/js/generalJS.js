var prevMenuIndex = 0;
var currMenuIndex = 0;
var liMenuArray = null;
var leftMarginPercentages = [25, 35, 45, 55, 65];

function setupMenuItemsMouseEventsHandler()
{
	liMenuArray = $("#menuUl li");

	liMenuArray.each(function(index, element)
		{
			$(element).mouseenter(function(eventObject)
				{	
					// Display the hover color
					$(this).attr("style", "background-color: #009933");
					
					prevMenuIndex = currMenuIndex;
					currMenuIndex = $(this).attr("tag");
					
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
					$(subMenuElement).attr("class", "subMenu horizontal");
				});
		});
	
	$("#Menu1").trigger("mouseenter");
}
