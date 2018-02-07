<%@include file="header.jsp" %>

<div id="content">
    <div class="container">
        <div class="row">

            <div id="comment-form">

                <h4 class="text-uppercase">poster votre publication</h4>

                <form action="insertPublication.jsp" method="post">
                    <div class="row">

                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="name">Photo <span class="required"></span>
                                </label>
                                <input type="file" id="photo" name="photo">
                            </div>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label for="comment">Description <span class="required">*</span>
                                </label>
                                <textarea class="form-control" id="desc" name="desc" rows="4"></textarea>
                            </div>
                        </div>
                    </div>

                        <div class="">
                            <button type="submit" class="btn btn-lg btn-template-primary">Publier</button>
                            <br>
                            <br>

                        </div>
                </form>

            </div>
        </div>
    </div>
    <!-- /.container -->
</div>
<%@include file="footer.jsp" %>