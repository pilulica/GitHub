function validate() {
    var toytype = document.getElementById("toytype").value;
    if (toytype == null || toytype == "" || toytype == " ") {
        alert("Please enter toy type.");
        return false;
    }
    var toyprice = document.getElementById("toyprice").value;
    if (toyprice == null || toyprice == "" || (isNaN(toyprice)) || toyprice <= 0) {
        alert("Please enter a valid price.");
        return false;
    }

    	var toyname = document.getElementById("toyname").value;
        if (toyname == null || toyname == "" || toyname == " ") {
            alert("Please enter toy name.");
            return false;
        }
    var toynumbers = document.getElementById("toynumbers").value;
    if (toynumbers == null || toynumbers == "" || (isNaN(toynumbers)) || toynumbers < 0) {
        alert("Please enter a valid number of sold toys.");
        return false;
    }
  return true;
  }