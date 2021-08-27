<link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>


<script>
    var jqOld = jQuery.noConflict();
    jqOld(function () {
        jqOld("#datepicker").datepicker();
        jqOld("#datepicker1").datepicker();
    })
</script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<div class="container">
    <form action="statistical_cost/list" method="post">
        <span>Start Day : </span><input id="datepicker" class="form-control" name="start" />
        <br>
        <span>End Day : </span><input id="datepicker1" class="form-control" name="end"/>
        <br>
        <input type="submit" value="submit" class="btn btn-info">
    </form>
</div>
