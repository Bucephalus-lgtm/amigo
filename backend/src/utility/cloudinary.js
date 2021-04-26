const cloudinary = require('cloudinary');

cloudinary.config({
  cloud_name: 'dymfk5fh1',
  api_key: '684238935118434',
  api_secret: '2ISL_JQYvoUPt8i1hiy61FZH6Q0'
});

exports.uploads = (file, folder) => {
  return new Promise(resolve => {
    cloudinary.uploader.upload(file, (result) => {
      resolve({
        url: result.url,
        id: result.public_id
      })
    }, {
      resource_type: "auto",
      folder: folder
    })
  })
}