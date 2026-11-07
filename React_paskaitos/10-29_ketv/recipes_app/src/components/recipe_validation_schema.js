import { z } from "zod";
import { CATEGORIES } from "../constants";

// Zod schema describing what a valid recipe looks like.
// React Hook Form uses it through zodResolver and shows the messages below on invalid fields.
export const recipeSchema = z.object({
  title: z.string().trim().min(3, "Title must be at least 3 characters"),

  image: z.string().trim().pipe(z.url("Enter a valid image URL")),

  category: z.enum(CATEGORIES, { message: "Please select a category" }),

  // The number input is registered with valueAsNumber, so an empty field arrives as NaN
  readyInMinutes: z
    .number({ message: "Enter the preparation time in minutes" })
    .int("Must be a whole number")
    .min(1, "Must be at least 1 minute"),

  // A single checkbox gives true / false
  vegetarian: z.boolean(),

  summary: z.string().trim().min(10, "Summary must be at least 10 characters"),

  // One ingredient per line
  ingredients: z.string().trim().min(1, "Add at least one ingredient"),

  instructions: z
    .string()
    .trim()
    .min(20, "Instructions must be at least 20 characters"),
});
