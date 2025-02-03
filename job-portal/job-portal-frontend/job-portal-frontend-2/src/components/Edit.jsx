// import React, { useEffect, useState } from "react";
// import { Typography, TextField, Button, Paper, Box } from "@mui/material";
// import { useLocation, useNavigate } from "react-router-dom";
// import axios from "axios";

// const initial = {
//   postId: "",
//   postProfile: "",
//   reqExperience: 0,
//   postTechStack: [],
//   postDesc: "",
// };

// const Edit = () => {
//   const location = useLocation();
//   const navigate = useNavigate();
//   const [form, setForm] = useState(initial);
//   const [currId] = useState(location.state.id);

//   useEffect(() => {
//     const fetchInitialPosts = async (id) => {  
//       try {
//         const response = await axios.get(`http://localhost:8080/jobpost/${id}`);
//         setForm(response.data);
//       } catch (error) {
//         console.error("Error fetching post:", error);
//       }
//     };
//     fetchInitialPosts(currId);
//   }, [currId]);

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     try {
//       if (currId) {
//         const response = await axios.put(`http://localhost:8080/jobpost/edit/${currId}`, form);
//         if (response.status === 200) {
//           navigate("/");
//         }
//       } else {
//         const response = await axios.post("http://localhost:8080/jobposts", form);
//         if (response.status === 200) {
//           navigate("/");
//         }
//       }
//     } catch (error) {
//       console.error("Error submitting form:", error);
//     }
//   };

//   const handleChange = (e) => {
//     const { checked, value } = e.target;
//     setForm(prevForm => ({
//       ...prevForm,
//       postTechStack: checked 
//         ? [...prevForm.postTechStack, value]
//         : prevForm.postTechStack.filter(skill => skill !== value)
//     }));
//   };

//   const skillSet = [
//     {
//       name: "Javascript",
//     },
//     {
//       name: "Java",
//     },
//     {
//       name: "Python",
//     },
//     {
//       name: "Django",
//     },
//     {
//       name: "Rust",
//     },
//   ];

//   return (
//     <Paper sx={{ padding: "1%" }} elevation={0}>
//       <Typography sx={{ margin: "3% auto" }} align="center" variant="h5">
//         Edit New Post
//       </Typography>
//       <form autoComplete="off" noValidate onSubmit={handleSubmit}>
//         <Box
//           sx={{
//             display: "flex",
//             justifyContent: "center",
//             flexDirection: "column",
//           }}
//         >
//           <TextField
//             min="0"
//             type="number"
//             sx={{ width: "50%", margin: "2% auto" }}
//             onChange={(e) => setForm({ ...form, postId: e.target.value })}
//             label="Enter your Post ID"
//             variant="outlined"
//             value={form.postId}
//           />
//           <TextField
//             type="string"
//             sx={{ width: "50%", margin: "2% auto" }}
//             required
//             onChange={(e) => setForm({ ...form, postProfile: e.target.value })}
//             label="Job-Profile"
//             variant="outlined"
//             value={form.postProfile}
//           />
//           <TextField
//             min="0"
//             type="number"
//             sx={{ width: "50%", margin: "2% auto" }}
//             required
//             onChange={(e) =>
//               setForm({ ...form, reqExperience: e.target.value })
//             }
//             label="Years of Experience"
//             variant="outlined"
//             value={form.reqExperience}
//           />
//           <TextField
//             type="string"
//             sx={{ width: "50%", margin: "2% auto" }}
//             required
//             multiline
//             rows={4}
//             onChange={(e) => setForm({ ...form, postDesc: e.target.value })}
//             label="Job-desc"
//             variant="outlined"
//             value={form.postDesc}
//           />
//           <Box sx={{ margin: "1% auto" }}>
//             <h3>Please mention required skills</h3>
//             <ul>
//               {skillSet.map(({ name }, index) => {
//                 return (
//                   <li key={index}>
//                     <div>
//                       <div>
//                         <input
//                           type="checkbox"
//                           id={`custom-checkbox-${index}`}
//                           name={name}
//                           value={name}
//                           onChange={handleChange}
//                         />
//                         <label htmlFor={`custom-checkbox-${index}`}>
//                           {name}
//                         </label>
//                       </div>
//                     </div>
//                   </li>
//                 );
//               })}
//             </ul>
//           </Box>
//           <Button
//             sx={{ width: "50%", margin: "2% auto" }}
//             variant="contained"
//             type="submit"
//             onClick={() => navigate("/")}
//           >
//             Submit
//           </Button>
//         </Box>
//       </form>
//     </Paper>
//   );
// };

// export default Edit;


//   // Rest of your component remains the same

import React, { useEffect, useState } from "react";
import { Typography, TextField, Button, Paper, Box } from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";

const initial = {
  postId: "",
  postProfile: "",
  reqExperience: 0,
  postTechStack: [],
  postDesc: "",
};

const Edit = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [form, setForm] = useState(initial);
  const [currId] = useState(location.state?.id);

  useEffect(() => {
    const fetchInitialPosts = async (id) => {  
      try {
        const response = await axios.get(`http://localhost:8080/jobpost/${id}`);
        setForm(response.data);
      } catch (error) {
        console.error("Error fetching post:", error);
      }
    };
    if (currId) fetchInitialPosts(currId);
  }, [currId]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.put(`http://localhost:8080/jobpost/edit/${form.postId}`, form);
      navigate("/");
    } catch (error) {
      console.error("Error updating post:", error);
    }
  };

  const handleChange = (e) => {
    const { checked, value } = e.target;
    setForm(prevForm => ({
      ...prevForm,
      postTechStack: checked 
        ? [...prevForm.postTechStack, value]
        : prevForm.postTechStack.filter(skill => skill !== value)
    }));
  };

  const skillSet = [
    { name: "Javascript" },
    { name: "Java" },
    { name: "Python" },
    { name: "Django" },
    { name: "Rust" }
  ];

  return (
    <Paper sx={{ padding: "1%" }} elevation={0}>
      <Typography sx={{ margin: "3% auto" }} align="center" variant="h5">
        Edit Job Post
      </Typography>
      <form autoComplete="off" noValidate onSubmit={handleSubmit}>
        <Box sx={{ display: "flex", justifyContent: "center", flexDirection: "column" }}>
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            onChange={(e) => setForm({ ...form, postId: e.target.value })}
            label="Post ID"
            variant="outlined"
            value={form.postId}
            disabled
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, postProfile: e.target.value })}
            label="Job-Profile"
            variant="outlined"
            value={form.postProfile}
          />
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, reqExperience: e.target.value })}
            label="Years of Experience"
            variant="outlined"
            value={form.reqExperience}
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            multiline
            rows={4}
            onChange={(e) => setForm({ ...form, postDesc: e.target.value })}
            label="Job-desc"
            variant="outlined"
            value={form.postDesc}
          />
          <Box sx={{ margin: "1% auto" }}>
            <h3>Required skills</h3>
            <ul>
              {skillSet.map(({ name }, index) => (
                <li key={index}>
                  <div>
                    <input
                      type="checkbox"
                      id={`custom-checkbox-${index}`}
                      name={name}
                      value={name}
                      checked={form.postTechStack.includes(name)}
                      onChange={handleChange}
                    />
                    <label htmlFor={`custom-checkbox-${index}`}>{name}</label>
                  </div>
                </li>
              ))}
            </ul>
          </Box>
          <Button
            sx={{ width: "50%", margin: "2% auto" }}
            variant="contained"
            type="submit"
          >
            Update
          </Button>
        </Box>
      </form>
    </Paper>
  );
};

export default Edit;