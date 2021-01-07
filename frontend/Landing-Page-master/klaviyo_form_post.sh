curl https://a.klaviyo.com/api/v1/list/dqQnNW/members \
  -X POST \
  -d api_key=pk_07205099b807bb3be2a727b566f1cb9dd9 \
  -d email=george.washington@example.com \
  -d properties='{ "$first_name" : "George", "Birthday" : "02/22/1732" }' \
  -d confirm_optin=true


fetch("https://a.klaviyo.com/api/v1/list/dqQnNW/members", {
  body: "api_key=pk_07205099b807bb3be2a727b566f1cb9dd9&email=george.washington@example.com&properties={ \"$first_name\" : \"George\", \"Birthday\" : \"02/22/1732\" }&confirm_optin=true",
  headers: {
    "Content-Type": "application/x-www-form-urlencoded"
  },
  method: "POST"
})
