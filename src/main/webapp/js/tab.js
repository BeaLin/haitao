function tabchange(a) {
	var ta=document.getElementById("tanalysis");
	var tp=document.getElementById("tproductlist");
	var diva = document.getElementById("tab-analysis");
	var divp = document.getElementById("tab-productlist");
	if (a.id == "tanalysis") {
		divp.style.display = "none";
		diva.style.display = "block";
		ta.className="selected";
		tp.className=""
	} else  {
		divp.style.display = "block";
		diva.style.display = "none";
		ta.className="";
		tp.className="selected"
	}
}