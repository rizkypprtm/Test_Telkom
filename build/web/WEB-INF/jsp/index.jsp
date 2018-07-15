<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>Test Spring Web MVC project</title>
    </head>

    <body>
        <form>
            <label>Search Title : </label>
            <input type="text" name="query" placeholder="Judul Buku">
            <br>
            <label>Sorting By : </label>
            <select name="sort">
                <option value="id">
                    Id
                </option>
                <option value="title">
                    Title
                </option>
                <option value="price">
                    Price
                </option>
                <option value="status">
                    Status
                </option>
            </select>
            <br>
            <label>Filter By : </label>
            <select name="filter">
                <option value ="All">
                    All
                </option>
                <option value="Active">
                    Active
                </option>
                <option value="Inactive">
                    Inactive
                </option>
            </select>
            <br>    
            <label>Page : </label>
            <input type="number" name="pageNumber" placeholder="Halaman" />
            <br>
            <label>Size Record : </label>
            <input type="number" name="pageSize" placeholder="Jumlah Data" />
            <br>
        </form>
        <br>
        <button id="button">
            Get Data
        </button>
        <br>
        <table border="1px">
            <thead>
                <td>Id</td>
                <td>Title</td>
                <td>Price</td>
                <td>Status</td>
            </thead>
            <tbody id="tableBody">
                
            </tbody>  
        </table>
    </body>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#button').click(function(){
                reloadData();
            });
            function reloadData(){
                var pageNumber = $('input[name=pageNumber]').val();
                var pageSize = $('input[name=pageSize]').val();
                var sort = $('select[name=sort]').val();
                var query = $('input[name=query]').val();
                var filter = $('select[name=filter]').val();
                $.ajax({
                    url: "data.htm",
                    data: {pageNumber: pageNumber, pageSize: pageSize, sort: sort, query: query, filter: filter},
                    type: 'GET',
                    success: function (response) {
                        var data = JSON.parse(response);
                        console.log(data);
                        var len = data.data.length;
                        var content = '';
                        for (var i = 0; i < len; i++){
                            content += '<tr>\n\
                                            <td> ' + data.data[i].id + '</td>\n\
                                            <td> ' + data.data[i].title + '</td>\n\
                                            <td> ' + data.data[i].price + '</td>\n\
                                            <td> ' + data.data[i].status + '</td>\n\
                                        </tr>';
                        }
                        $("#tableBody").html(content);
                    }
                });
            }
        });
    </script>
</html>
