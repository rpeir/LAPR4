function generateTable(rows, columns) {
    let i;
// Create the table element
    const table = document.createElement("table");
    // Create the table headers
    const thead = document.createElement("thead");
    const headerRow = document.createElement("tr");
    const empty = document.createElement("th");
    headerRow.appendChild(empty);
    for (i = 1; i <= columns; i++) {
        const th = document.createElement("th");
        th.textContent = `Column ${i}`;
        headerRow.appendChild(th);
    }
    thead.appendChild(headerRow);
    table.appendChild(thead);

    // Create the table rows
    const tbody = document.createElement("tbody");
    for (i = 1; i <= rows; i++) {
        const row = document.createElement("tr");
        const rowHeader = document.createElement("th");
        rowHeader.textContent = `Row ${i}`;
        row.appendChild(rowHeader);
        for (let j = 1; j <= columns; j++) {
            const cell = document.createElement("td");
            cell.id = `post-${i}-${j}`;
            row.appendChild(cell);
        }
        tbody.appendChild(row);
    }
    table.appendChild(tbody);

    // Append the table to the container
    document.body.appendChild(table);

    boards();
}
    // ADD
    function boards(){
        var request = new XMLHttpRequest();
        var vBoard = document.getElementById("boards");

        request.onload = function() {
            vBoard.innerHTML = this.responseText;
            vBoard.style.color="black";
            setTimeout(boards, 2000);
        };

        // request.ontimeout = function() {
        //     vBoard.innerHTML = "Server timeout, still trying ...";
        //     vBoard.style.color="red";
        //     setTimeout(boards, 100);
        // };
        //
        // request.onerror = function() {
        //     vBoard.innerHTML = "No server reply, still trying ...";
        //     vBoard.style.color="red";
        //     setTimeout(boards, 5000);
        // };

        request.open("GET","/boards",true);
        request.timeout = 5000;
        request.send();
    }


