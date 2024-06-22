<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .profile-pic-container {
            width: 150px;
            height: 150px;
            position: relative;
            margin: 0 auto;
        }
        .profile-pic-container img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 50%;
        }
    </style>
</head>
<body>
<jsp:include page="./common/header.jsp"></jsp:include>
<div class="container-xl px-4 mt-4">
    <nav class="nav nav-borders">
        <a class="nav-link" href="feedback.jsp" >Feedback</a>
    </nav>
    <hr class="mt-0 mb-4">
    <div class="row">
        <div class="col-xl-4">
            <div class="card mb-4 mb-xl-0">
                <div class="card-header">Profile Picture</div>
                <div class="card-body text-center">
                    <div class="profile-pic-container">
                        <img id="profileImage" class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                    </div>
                    <div class="small font-italic text-muted mb-4">JPG or PNG less than 5 MB</div>
                    <input type="file" id="uploadImage" accept="image/*" style="display: none;">
                    <button class="btn btn-primary" type="button" onclick="document.getElementById('uploadImage').click();">Upload image</button>
                </div>
            </div>
        </div>

        <div class="col-xl-8">
            <div class="card mb-4">
                <div class="card-header">User Details</div>
                <div class="card-body">
                    <form id="updateForm" action="user-update" method="post">
                        <div class="mb-3">
                            <fieldset class="form-group">
                                <p>User ID: ${userId}</p>
                            </fieldset>
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <fieldset class="form-group">
                                    <label class="small mb-1" for="firstname">First name</label>
                                    <input class="form-control" id="firstname" name="firstname" type="text" placeholder="Enter your first name" required>
                                </fieldset>
                            </div>
                            <div class="col-md-6">
                                <fieldset class="form-group">
                                    <label class="small mb-1" for="lastname">Last name</label>
                                    <input class="form-control" id="lastname" name="lastname" type="text" placeholder="Enter your last name" required>
                                </fieldset>
                            </div>
                        </div>
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <fieldset class="form-group">
                                    <label class="small mb-1" for="email">Email address</label>
                                    <input class="form-control" id="email" name="email" type="email" placeholder="Enter your email address" value="${email}" required>
                                </fieldset>
                            </div>
                            <div class="col-md-6">
                                <fieldset class="form-group">
                                    <label class="small mb-1" for="phone">Phone number</label>
                                    <input class="form-control" id="phone" name="phone" type="tel" placeholder="Phone number" maxlength="12" pattern="[0-9]{10}" title="Please enter a valid phone number (10 digits)" oninput="validatePhoneNumber(this)" required>
                                    <div id="phoneWarning" class="small text-danger mt-1" style="display: none;">Phone number must be exactly 10 digits long.</div>
                                </fieldset>
                            </div>
                        </div>
                        <div class="mb-3">
                            <fieldset class="form-group">
                                <label class="small mb-1" for="address">Address</label>
                                <input class="form-control" id="address" name="address" type="text" placeholder="Enter your address" required>
                            </fieldset>
                        </div>
                        <div class="container text-left">
                            <button type="submit" class="btn btn-success">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    document.getElementById('uploadImage').addEventListener('change', function() {
        const file = this.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(event) {
                document.getElementById('profileImage').setAttribute('src', event.target.result);
            }
            reader.readAsDataURL(file);
        }
    });

    document.getElementById('updateForm').addEventListener('submit', function(event) {
        const form = event.target;
        const fields = ['firstname', 'lastname', 'email', 'dateofbirth', 'country', 'phone', 'address'];
        let allFilled = true;

        fields.forEach(field => {
            const input = document.getElementById(field);
            if (!input.value || (field === 'phone' && input.value.length !== 10)) {
                allFilled = false;
                input.classList.add('is-invalid'); // Optional: add a class to highlight empty fields
            } else {
                input.classList.remove('is-invalid');
            }
        });

        if (!allFilled) {
            event.preventDefault();
            alert('Please fill in all the details.');
        }
    });

    function validatePhoneNumber(input) {
        // Remove any non-digit characters
        input.value = input.value.replace(/\D/g, '');
        
        // Get the warning message element
        const warning = document.getElementById('phoneWarning');
        
        // Show the warning if the input length is less than or greater than 12 digits
        if (input.value.length > 0 && input.value.length !== 10) {
            warning.style.display = 'block';
        } else {
            warning.style.display = 'none';
        }
    }
</script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
