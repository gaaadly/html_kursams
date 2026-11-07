import { z } from "zod";

export const schemaYoutube = z
  .object({
    username: z
      .string()
      .trim()
      .min(2, "Username must be at least 2 characters")
      .refine((value) => !value.includes(" "), {
        message: "Username contains space",
      })
      .refine(
        (value) => !["admin", "root"].includes(value.toLocaleLowerCase()),
        "Username is reserved",
      ),
    password: z
      .string()
      .min(6, "Pass must be at least 6 symbols long")
      .regex(/[A-Z]/, "pass has to have at least one upper case")
      .regex(/[0-9]/, "must be at leaat one number"),
    confirmPassword: z.string().min(1, "Please confirm your password"),
    email: z
      .string()
      .trim()
      .min(1, "Email is required")
      .pipe(z.email("Invalid email address")),
    channel: z.string().min(1, "Please select a channel"),
    favColor: z.enum(["red", "green", "blue"], {
      message: "Please choose a color",
    }),
    hobbies: z.array(z.string()).min(1, "Select at least one hobby"),
  })
  .refine((data) => data.password === data.confirmPassword, {
    message: "Passwords must be the same",
    path: ["confirmPassword"],
  });
