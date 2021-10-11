		let xhtp = new XMLHttpRequest();
		xhtp.onload = function() {
			let data = JSON.parse(xhtp.responseText);
			console.log(data);
			showEmpList(data);
		}
		xhtp.open('get', '../empJsonServlet.json');
		xhtp.send();
		
		function showEmpList(data) {
			let table, tr, td, txt;

			table = document.createElement('table');
			table.setAttribute('border','1');

            // 내가 한 것

            // titles = ['사원번호', '이름', '이메일', '입사일', '부서번호'];
            //
			// // 타이틀(헤더)
			// tr = document.createElement('tr');
			// for (let title of titles) {
            //     td = document.createElement('th');
            //     txt = document.createTextNode(title);
            //     td.appendChild(txt);
            //     tr.appendChild(td);
            // }
            // table.appendChild(tr);

			// //데이터부분
			// for (let i = 0; i < data.length ; i++) {
            //     tr = document.createElement('tr'); 
            //     for (let j=0; j<7 ; j++) {
            //         td = document.createElement('td');
            //         let empId = data[i].childNodes[j].firstChild.nodeValue;
            //         txt = document.createTextNode(empId);
            //         td.appendChild(txt);
            //         tr.appendChild(td);
            //     }
            //     table.appendChild(tr);
			// }
            //document.getElementById('show').appendChild(table);
			
            // function 지정
            table.appendChild(getTitle());
            
            for (let row of data) {
                table.appendChild(getRow(row));
            }
            
            document.getElementById('show').appendChild(table);

		}

        function getRow(row) {  //데이터 한건 처리
            let tr, td;
            tr = document.createElement('tr');
            for (let field in row) {
                td = document.createElement('td');
                td.appendChild(document.createTextNode(row[field]));
                tr.appendChild(td);
            }
            return tr;
        }

        function getTitle() {
            let titles = ['사원번호', '이름', '이메일', '입사일', '부서번호', '기능'];
			let tr, td;
            tr = document.createElement('tr');
            for (let i = 0;i < titles.length; i++) {
                td = document.createElement('td');
                txt = document.createTextNode(titles[i]);
                td.appendChild(txt);
                tr.appendChild(td);
            }
            return tr;
        }