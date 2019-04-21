use test
db.dropUser("myretailuser")
db.createUser({
    user: 'myretailuser',
    pwd: 'MyRetail_pwd',
    roles: [
        {
            role: 'readwrite',
            db: 'test'
        }
    ]

})