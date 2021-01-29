


window.onload = function() {
    loadStats();
}

async function loadStats() {
    try {
        let stats = await $.ajax({
            url: "/api/customers/statistics/invoices",
            method: "get",
            dataType: "json"
        });
        let tbody = document.getElementById("stats");
        let html = "";
        for (const stat of stats) {
            html+="<tr><td>"+stat.firstName + " "+stat.lastName +"</td>"+
            "<td>"+stat.total+"</td><td>"+stat.cost+" € </td></tr>";
        }
        
        tbody.innerHTML = html;
    } catch(err) {
        // Tratar do erro depois
        /*
        let elemMain = document.getElementById("main");
        console.log(err);
        elemMain.innerHTML = "<h1> Página não está disponível</h1>"+
                "<h2> Por favor tente mais tarde</h2>";
                */
    }
} 
