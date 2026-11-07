import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { recipeSchema } from "./recipe_validation_schema";
import { CATEGORIES } from "../constants";
import { getOne } from "../services/get";
import postData from "../services/post";
import updateData from "../services/update";

// One form for two jobs:
//   /add       -> no id in the URL -> creates a new recipe (POST)
//   /edit/:id  -> id in the URL    -> loads the recipe and updates it (PATCH)
function RecipeForm({ onSaved }) {
  const { id } = useParams();
  const isEdit = Boolean(id);
  const navigate = useNavigate();
  const [errormsg, setErrorMsg] = useState("");

  const {
    register, // connects an input to the form: <input {...register("title")} />
    handleSubmit, // validates first, calls our function only if the data is valid
    reset, // sets all fields back to the given values (or to defaultValues)
    formState: { errors, isSubmitting },
  } = useForm({
    mode: "onBlur", // validate a field when the user leaves it
    reValidateMode: "onChange", // after an error, re-check on every keystroke
    defaultValues: {
      title: "",
      image: "",
      category: "",
      readyInMinutes: "",
      vegetarian: false,
      summary: "",
      ingredients: "",
      instructions: "",
    },
    // resolver = adapter that plugs the Zod schema into React Hook Form
    resolver: zodResolver(recipeSchema),
  });

  // Edit mode: load the existing recipe and put its values into the form fields
  useEffect(() => {
    if (!id) return;

    const loadRecipe = async () => {
      try {
        const recipe = await getOne(id);
        reset(recipe);
      } catch (error) {
        setErrorMsg(error.message);
      }
    };
    loadRecipe();
  }, [id, reset]);

  // Called with the validated form data (an object) when the form is submitted
  const formSubmitHandler = async (formData) => {
    try {
      if (isEdit) {
        await updateData(id, formData);
      } else {
        await postData(formData);
      }
      await onSaved(); // reload the recipe list in App
      navigate(isEdit ? `/recipes/${id}` : "/"); // go to the recipe / home page
    } catch (error) {
      setErrorMsg(error.message);
    }
  };

  return (
    <>
      <h1 className="mb-4 text-2xl font-bold">
        {isEdit ? "Edit recipe" : "Add recipe"}
      </h1>
      {errormsg && <p className="error">{errormsg}</p>}

      {/* noValidate turns off the browser's own validation, Zod does it instead */}
      <form
        onSubmit={handleSubmit(formSubmitHandler)}
        noValidate
        className="flex max-w-xl flex-col gap-3"
      >
        <div>
          <label htmlFor="title">Title:</label>
          <input
            id="title"
            type="text"
            className="w-full border p-1"
            {...register("title")}
          />
          <div className="error">{errors.title?.message}</div>
        </div>

        <div>
          <label htmlFor="image">Image URL:</label>
          <input
            id="image"
            type="text"
            className="w-full border p-1"
            {...register("image")}
          />
          <div className="error">{errors.image?.message}</div>
        </div>

        <div>
          <label htmlFor="category">Category:</label>
          <select
            id="category"
            className="w-full border p-1"
            {...register("category")}
          >
            <option value="">-- Select a category --</option>
            {CATEGORIES.map((category) => (
              <option key={category} value={category}>
                {category}
              </option>
            ))}
          </select>
          <div className="error">{errors.category?.message}</div>
        </div>

        <div>
          <label htmlFor="readyInMinutes">Ready in (minutes):</label>
          <input
            id="readyInMinutes"
            type="number"
            className="w-full border p-1"
            // valueAsNumber returns a number instead of a string
            {...register("readyInMinutes", { valueAsNumber: true })}
          />
          <div className="error">{errors.readyInMinutes?.message}</div>
        </div>

        <div>
          <label>
            <input type="checkbox" {...register("vegetarian")} /> Vegetarian
          </label>
        </div>

        <div>
          <label htmlFor="summary">Summary:</label>
          <textarea
            id="summary"
            rows={3}
            className="w-full border p-1"
            {...register("summary")}
          />
          <div className="error">{errors.summary?.message}</div>
        </div>

        <div>
          <label htmlFor="ingredients">Ingredients (one per line):</label>
          <textarea
            id="ingredients"
            rows={5}
            className="w-full border p-1"
            {...register("ingredients")}
          />
          <div className="error">{errors.ingredients?.message}</div>
        </div>

        <div>
          <label htmlFor="instructions">Instructions:</label>
          <textarea
            id="instructions"
            rows={6}
            className="w-full border p-1"
            {...register("instructions")}
          />
          <div className="error">{errors.instructions?.message}</div>
        </div>

        <div className="flex gap-2">
          {/* isSubmitting is true while the request is running -> prevents double submit */}
          <button type="submit" disabled={isSubmitting} className="border px-3 py-1">
            {isEdit ? "Save changes" : "Add recipe"}
          </button>
          {/* type="button" so it doesn't submit the form; reset() restores the starting values */}
          <button type="button" onClick={() => reset()} className="border px-3 py-1">
            Reset
          </button>
        </div>
      </form>
    </>
  );
}

export default RecipeForm;
